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

/**
 *
 * @author Администратор
 */
public enum ControlPattern {

    Annotation(10023),
    Dock(10011),
    Drag(10030),
    DropTarget(10031),
    ExpandCollapse(10005),
    GridItem(10007),
    Grid(10006),
    Invoke(10000),
    ItemContainer(10019),
    LegacyIAccessible(10018),
    MultipleView(10008),
    ObjectModel(10022),
    RangeValue(10003),
    ScrollItem(10017),
    Scroll(10004),
    SelectionItem(10010),
    Selection(10001),
    Spreadsheet(10026),
    SpreadsheetItem(10027),
    Styles(10025),
    SynchronizedInput(10021),
    TableItem(10013),
    Table(10012),
    TextChild(10029),
    Text(10014),
    Text2(10024),
    Toggle(10015),
    Transform(10016),
    Transform2(10028),
    Value(10002),
    VirtualizedItem(10020),
    Window(10009);
    private int value;

    private ControlPattern(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
