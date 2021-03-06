/**
 * Copyright (c) 2014 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the End User License
 * Agreement for Liferay IDE ("License"). You may not use this file
 * except in compliance with the License. You can obtain a copy of the License
 * by contacting Liferay, Inc. See the License for the specific language
 * governing permissions and limitations under the License, including but not
 * limited to distribution rights of the Software.
 */
package com.liferay.ide.kaleo.core.model;

import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;

/**
 * @author Gregory Amerson
 */
public interface Node extends Describable
{

    ElementType TYPE = new ElementType( Node.class );

    // *** Name ***

    @XmlBinding( path = "name" )
    @Label( standard = "&name" )
    @Required
    ValueProperty PROP_NAME = new ValueProperty( TYPE, "Name" );

    Value<String> getName();
    void setName( String value );

}
