/*
   Copyright (C) 2012-2013 Anton Lobov <zhuravlik> <ahmad200512[at]yandex.ru>

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
package zhuravlik.automation.jna.patterns;

import java.util.EnumSet;
import zhuravlik.automation.jna.patterns.raw.IUIAutomationSynchronizedInputPattern;
import zhuravlik.automation.util.win32.SynchronizedInputType;

/**
 *
 * @author Администратор
 */

public class SynchronizedInputPattern {
    private IUIAutomationSynchronizedInputPattern rawPattern;
    
    public SynchronizedInputPattern(IUIAutomationSynchronizedInputPattern rawPattern) {
        this.rawPattern = rawPattern;
    }
    
    public void startListening(EnumSet<SynchronizedInputType> inputTypes) {
        int value = 0;
        for (SynchronizedInputType type: inputTypes) {
            value |= type.getId();
        }
        
        rawPattern.StartListening(value);
    }
    
    public void cancel() {
        rawPattern.Cancel();
    }
}
