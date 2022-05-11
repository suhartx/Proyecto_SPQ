package com.BGS006.dao;

import java.util.List;

//This interface defines the basic methods of Data Access Object Pattern
//This interface uses the concept of a "template".
//Classes implementing it must specify the concrete type on which the methods are applied.
public interface IDataAccessObject<DomainObject> {
	public void delete(DomainObject object);

	public DomainObject find(String param);

	public List<DomainObject> getAll();

	public void save(DomainObject object);
}
