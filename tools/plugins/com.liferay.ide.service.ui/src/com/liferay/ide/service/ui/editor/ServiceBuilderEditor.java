/*******************************************************************************
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * Contributors:
 * 		Gregory Amerson - initial implementation and ongoing maintenance
 *******************************************************************************/

package com.liferay.ide.service.ui.editor;

import com.liferay.ide.service.core.model.ServiceBuilder6xx;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.sapphire.ui.swt.xml.editor.SapphireEditorForXml;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.part.FileEditorInput;

/**
 * @author Gregory Amerson
 */
public class ServiceBuilderEditor extends SapphireEditorForXml
{
    public ServiceBuilderEditor()
    {
        super( ServiceBuilder6xx.TYPE, null );
    }

    @Override
    protected void createFormPages() throws PartInitException
    {
        addDeferredPage( 1, "Overview", "serviceBuilderPage" );
    }

    @Override
    protected void createDiagramPages() throws PartInitException
    {
        addDeferredPage( 2, "Diagram", "diagramPage" );
    }

    public InputStream getFileContents() throws CoreException, MalformedURLException, IOException
    {
        final IEditorInput editorInput = getEditorInput();

        if( editorInput instanceof FileEditorInput )
        {
            return ( (FileEditorInput) editorInput ).getFile().getContents();
        }
        else if( editorInput instanceof IStorageEditorInput )
        {
            return ( (IStorageEditorInput) editorInput ).getStorage().getContents();
        }
        else if( editorInput instanceof FileStoreEditorInput )
        {
            return ( (FileStoreEditorInput) editorInput ).getURI().toURL().openStream();
        }
        else
        {
            return null;
        }
    }
}
