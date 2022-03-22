/**********************************************************************
Copyright (c) 2003 Andy Jefferson and others. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Contributors:
    ...
**********************************************************************/
package org.datanucleus.samples.jdo.tutorial;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;

/**
 * Definition of a Book. Extends basic Product class.
 * @author      Diego Lopez-de-Ipina 
 * @version     1.0                                    
 * @since       2012-02-01        
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Book extends Product
{
	/**
	 * This variable represents the name of a book author
	 */
    protected String author=null;
	/**
	 * This variable represents the isbn of a book
	 */
    protected String isbn=null;
	/**
	 * This variable represents the name of the publisher of a book
	 */
    protected String publisher=null;

	/**
	 * Void constructor of Book
	 */
    protected Book()
    {
        super();
    }

	/**
	 * Parametized constructor of book receiving as parameters:
	 * @param name String corresponding to the title of the book 
	 * @param description String corresponding to the name of the book author
	 * @param price double corresponding to the price of the book
	 * @param author String corresponding to the name of the book author
	 * @param isbn String corresponding to the ISBN of the book
	 * @param publisher String corresponding to the name of the book publisher
	*/
    public Book(String name, String description, double price, String author, String isbn, String publisher)
    {
        super(name,description,price);
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
    }

	/**
	 * Getter for the name of the auhor
	 * @return The String corresponding to the name of the author
	 */
    public String getAuthor()
    {
        return author;
    }

	/**
	 * Getter for the book ISBN
	 * @return The String corresponding to the book ISBN
	 */
    public String getIsbn()
    {
        return isbn;
    }

	/**
	 * Getter for the name of the book publisher
	 * @return The String corresponding to the book publisher
	 */
    public String getPublisher()
    {
        return publisher;
    }

	/**
	 * Setter for the book author
	 * @param author The String corresponding to the book author
	 */
    public void setAuthor(String author)
    {
        this.author = author;
    }

	/**
	 * Setter for the book isbn
	 * @param isbn The String corresponding to the book isbn
	 */
    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

	/**
	 * Setter for the book publisher
	 * @param publisher The String corresponding to the book publisher
	 */
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

	/**
	 * String representation of a Book object instance
	 * @return The String corresponding to the string representation of a Book instance
	 */
    public String toString()
    {
        return "Book : " + author + " - " + name;
    }
}