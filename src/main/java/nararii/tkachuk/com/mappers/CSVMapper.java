package nararii.tkachuk.com.mappers;

import nararii.tkachuk.com.entities.CSVSerializable;

public interface CSVMapper<T extends CSVSerializable> {

    T mapFromCSV(String s);

}
