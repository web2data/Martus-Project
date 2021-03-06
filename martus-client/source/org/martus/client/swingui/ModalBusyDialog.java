/*

The Martus(tm) free, social justice documentation and
monitoring software. Copyright (C) 2006-2007, Beneficent
Technology, Inc. (The Benetech Initiative).

Martus is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either
version 2 of the License, or (at your option) any later
version with the additions and exceptions described in the
accompanying Martus license file entitled "license.txt".

It is distributed WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, including warranties of fitness of purpose or
merchantability.  See the accompanying Martus License and
GPL license for more details on the required license terms
for this software.

You should have received a copy of the GNU General Public
License along with this program; if not, write to the Free
Software Foundation, Inc., 59 Temple Place - Suite 330,
Boston, MA 02111-1307, USA.

*/

package org.martus.client.swingui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.martus.clientside.UiLocalization;
import org.martus.swing.Utilities;

public class ModalBusyDialog extends JDialog
{
	public ModalBusyDialog(UiMainWindow mainWindow, String dialogTag)
	{
		super(mainWindow.getCurrentActiveFrame().getSwingFrame());
		UiLocalization localization = mainWindow.getLocalization();
		setModal(true);
		setTitle(localization.getWindowTitle(dialogTag));
		getRootPane().setBorder(new LineBorder(Color.black, 5));
		JLabel text = new JLabel(localization.getFieldLabel(dialogTag));
		text.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(text, BorderLayout.CENTER);
		setUndecorated(true);
		Utilities.packAndCenterWindow(this);
	}
	
	public void workerFinished()
	{
		dispose();
	}
}