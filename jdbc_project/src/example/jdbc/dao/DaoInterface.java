package example.jdbc.dao;

import java.util.Collection;

public interface DaoInterface <T,K>
//T =type and K=Key
{
//A method to retrieve all records
	Collection <T> retrieveAll();
	
	//A method to retrieve a single record
	
	T retrieveOne(K key);
}
