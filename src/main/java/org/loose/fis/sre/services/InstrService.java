package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.exceptions.UsernameNotExistsException;
import org.loose.fis.sre.model.Instrument;
import java.util.Objects;
import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class InstrService {
    private static ObjectRepository<Instrument> InstrRepository;   //repository-ul pentru Instrumente
    //private static ObjectRepository<Instrument> InstrRepository = InstrService.GetRepository();   //repository-ul pentru Instrumente

    public static void initDatabaseInstr() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("Instrumente.db").toFile())
                .openOrCreate("test", "test");

        InstrRepository = database.getRepository(Instrument.class);
    }

    public static void addInstr(String name, String category, String descr, String price, String buyer, String seller) throws UsernameAlreadyExistsException {
        checkInstrDoesNotAlreadyExist(name);
        InstrRepository.insert(new Instrument(name, category, descr, price, buyer, seller));
    }

    public static void checkInstrDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (Instrument instr : InstrRepository.find()) {
            if (Objects.equals(username, instr.getName()))
                throw new UsernameAlreadyExistsException(username);
        }
    }
    public static void checkInstrDoesNotExist(String username) throws UsernameNotExistsException {
        int c = 0;
        for (Instrument instr : InstrRepository.find()) {
            if (Objects.equals(username, instr.getName())) c = 1;
        }
        if(c == 0) throw new UsernameNotExistsException(username);
    }
    public static void deleteInstr(String numeInstr) throws UsernameNotExistsException {
        checkInstrDoesNotExist(numeInstr);
        String numeP=new String();
        for(Instrument instr : InstrRepository.find()){
            if(instr.getName().equals(numeInstr)){
                numeP=numeInstr;
            }
        }InstrRepository.remove(ObjectFilters.eq("name",numeP));
    }

    public static ObjectRepository<Instrument> GetRepository() {
        return InstrRepository;
    }
}
