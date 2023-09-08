/*
    Copyright (C) 2012-2013 Anton Lobov <zhuravlik> <ahmad200512[at]yandex.ru>

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
*/

package zhuravlik.automation.util.win32;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Администратор
 */
public enum TreeScope {
    Element(1),
    Children(2),
    Descendants(4),
    Parent(8),
    Ancestors(16),
    Subtree(7);
  
  private int value;
    
    private static final Map<Integer, TreeScope> lookup = new HashMap<Integer, TreeScope>();

  static{
    for (TreeScope suit : TreeScope.values()) {
      lookup.put(suit.getId(), suit);
    }
  }

  public static TreeScope fromId(int id) {
    return lookup.get(id);
  }
    
    
    public int getId() {
        return value;
    }

    private TreeScope(int value) {
        this.value = value;
    }
}
