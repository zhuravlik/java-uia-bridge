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
