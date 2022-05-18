package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
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

    public static void addInstr(String name, String category, String descr, String price) throws UsernameAlreadyExistsException {
        checkInstrDoesNotAlreadyExist(name);
        InstrRepository.insert(new Instrument(name, category, descr, price));
    }

    public static void checkInstrDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (Instrument instr : InstrRepository.find()) {
            if (Objects.equals(username, instr.getName()))
                throw new UsernameAlreadyExistsException(username);
        }
    }

    public static ObjectRepository<Instrument> GetRepository() {
        return InstrRepository;
    }
}
