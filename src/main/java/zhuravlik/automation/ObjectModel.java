/*
   Copyright (C) 2012 Anton Lobov <zhuravlik> <ahmad200512[at]yandex.ru>

   This library is free software; you can redistribute it and/or
   modify it under the terms of the GNU Lesser General Public
   License as published by the Free Software Foundation; either
   version 3 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
   Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General
   Public License along with this library; if not, write to the
   Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
   Boston, MA 02110-1301 USA
*/
package zhuravlik.automation;

import org.jaxen.BaseXPath;
import org.jaxen.JaxenException;
import zhuravlik.automation.uom.*;

public class ObjectModel {
    public static Object locateObject(String parent, String model, String opath)
        throws JaxenException, UnsupportedModelException {
        
        BaseXPath xp;
        
        if (model.equals("win32")) {
            xp = new BaseXPath(opath, new Win32Navigator());
        }
        else if (model.equals("msaa")) {
            xp = new BaseXPath(opath, new MSAANavigator());
        }
        else if (model.equals("x11")) {
            xp = new BaseXPath(opath, new X11Navigator());
        }
        else if (model.equals("at-spi")) {
            xp = new BaseXPath(opath, new ATSPINavigator());
        }
        else
            throw new UnsupportedModelException(model);
        
        return xp.evaluate(parent);
    }
}
