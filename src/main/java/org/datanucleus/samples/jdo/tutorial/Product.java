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
 * Definition of a Product
 * Represents a product, and contains the key aspects of the item.
 * @author      Diego Lopez-de-Ipina 
 * @version     1.0                                    
 * @since       2012-02-01        
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Product
{
    protected String name=null;

    protected String description=null;

    protected double price=0.0;

    protected Product()
    {
    }

    public Product(String name, String description, double price)
    {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public double getPrice()
    {
        return price;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String toString()
    {
        return "Product : " + name + " [" + description + "]";
    }
}