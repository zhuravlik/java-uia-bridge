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
public enum ControlType {
    Button(50000),
    Calendar(50001),
    CheckBox(50002),
    ComboBox(50003),
    Custom(50025),
    DataGrid(50028),
    DataItem(50029),
    Document(50030),
    Edit(50004),
    Group(50026),
    Header(50034),
    HeaderItem(50035),
    Hyperlink(50005),
    Image(50006),
    List(50008),
    ListItem(50007),
    MenuBar(50010),
    Menu(50009),
    MenuItem(50011),
    Pane(50033),
    ProgressBar(50012),
    RadioButton(50013),
    ScrollBar(50014),
    SemanticZoom(50039),
    Separator(50038),
    Slider(50015),
    Spinner(50016),
    SplitButton(50031),
    StatusBar(50017),
    Tab(50018),
    TabItem(50019),
    Table(50036),
    Text(50020),
    Thumb(50027),
    TitleBar(50037),
    ToolBar(50021),
    ToolTip(50022),
    Tree(50023),
    TreeItem(50024),
    Window(50032);
    private int value;
    
    private static final Map<Integer, ControlType> lookup = new HashMap<Integer, ControlType>();

  static{
    for (ControlType suit : ControlType.values()) {
      lookup.put(suit.getId(), suit);
    }
  }

  public static ControlType fromId(int id) {
    return lookup.get(id);
  }
    
    
    public int getId() {
        return value;
    }

    private ControlType(int value) {
        this.value = value;
    }
}
