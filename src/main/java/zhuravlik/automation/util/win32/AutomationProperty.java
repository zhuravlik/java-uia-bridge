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

import com.sun.jna.platform.win32.Variant;

/**
 *
 * @author Администратор
 */
public enum AutomationProperty {
         RuntimeId(30000, Variant.VT_INT),
         BoundingRectangle(30001, Variant.VT_I4),
         ProcessId(30002, Variant.VT_INT),
         ControlType(30003, Variant.VT_INT),
         LocalizedControlType(30004, Variant.VT_LPWSTR),
         Name(30005, Variant.VT_LPWSTR),
         AcceleratorKey(30006, Variant.VT_LPWSTR),
         AccessKey(30007, Variant.VT_LPWSTR),
         HasKeyboardFocus(30008, Variant.VT_BOOL),
         IsKeyboardFocusable(30009, Variant.VT_BOOL),
         IsEnabled(30010, Variant.VT_BOOL),
         AutomationId(30011, Variant.VT_LPWSTR),
         ClassName(30012, Variant.VT_LPWSTR),
         HelpText(30013, Variant.VT_LPWSTR),
         ClickablePoint(30014, Variant.VT_I2),
         Culture(30015, Variant.VT_LPWSTR),
         IsControlElement(30016, Variant.VT_BOOL),
         IsContentElement(30017, Variant.VT_BOOL),
         LabeledBy(30018, Variant.VT_LPWSTR),
         IsPassword(30019, Variant.VT_BOOL),
         NativeWindowHandle(30020, Variant.VT_INT),
         ItemType(30021, Variant.VT_INT),
         IsOffscreen(30022, Variant.VT_BOOL),
         Orientation(30023, Variant.VT_INT),
         FrameworkId(30024, Variant.VT_LPWSTR),
         IsRequiredForForm(30025, Variant.VT_BOOL),
         ItemStatus(30026, Variant.VT_LPWSTR),
         IsDockPatternAvailable(30027, Variant.VT_BOOL),
         IsExpandCollapsePatternAvailable(30028, Variant.VT_BOOL),
         IsGridItemPatternAvailable(30029, Variant.VT_BOOL),
         IsGridPatternAvailable(30030, Variant.VT_BOOL),
         IsInvokePatternAvailable(30031, Variant.VT_BOOL),
         IsMultipleViewPatternAvailable(30032, Variant.VT_BOOL),
         IsRangeValuePatternAvailable(30033, Variant.VT_BOOL),
         IsScrollPatternAvailable(30034, Variant.VT_BOOL),
         IsScrollItemPatternAvailable(30035, Variant.VT_BOOL),
         IsSelectionItemPatternAvailable(30036, Variant.VT_BOOL),
         IsSelectionPatternAvailable(30037, Variant.VT_BOOL),
         IsTablePatternAvailable(30038, Variant.VT_BOOL),
         IsTableItemPatternAvailable(30039, Variant.VT_BOOL),
         IsTextPatternAvailable(30040, Variant.VT_BOOL),
         IsTogglePatternAvailable(30041, Variant.VT_BOOL),
         IsTransformPatternAvailable(30042, Variant.VT_BOOL),
         IsValuePatternAvailable(30043, Variant.VT_BOOL),
         IsWindowPatternAvailable(30044, Variant.VT_BOOL),
         ValueValue(30045, Variant.VT_LPWSTR),
         ValueIsReadOnly(30046, Variant.VT_BOOL),
         RangeValueValue(30047, Variant.VT_LPWSTR),
         RangeValueIsReadOnly(30048, Variant.VT_BOOL),
         RangeValueMinimum(30049, Variant.VT_INT),
         RangeValueMaximum(30050, Variant.VT_INT),
         RangeValueLargeChange(30051, Variant.VT_INT),
         RangeValueSmallChange(30052, Variant.VT_INT),
         ScrollHorizontalScrollPercent(30053, Variant.VT_INT),
         ScrollHorizontalViewSize(30054, Variant.VT_INT),
         ScrollVerticalScrollPercent(30055, Variant.VT_INT),
         ScrollVerticalViewSize(30056, Variant.VT_INT),
         ScrollHorizontallyScrollable(30057, Variant.VT_BOOL),
         ScrollVerticallyScrollable(30058, Variant.VT_BOOL),
         SelectionSelection(30059, Variant.VT_LPWSTR),
         SelectionCanSelectMultiple(30060, Variant.VT_BOOL),
         SelectionIsSelectionRequired(30061, Variant.VT_BOOL),
         GridRowCount(30062, Variant.VT_INT),
         GridColumnCount(30063, Variant.VT_INT),
         GridItemRow(30064, Variant.VT_INT),
         GridItemColumn(30065, Variant.VT_INT),
         GridItemRowSpan(30066, Variant.VT_INT),
         GridItemColumnSpan(30067, Variant.VT_INT),
         GridItemContainingGrid(30068, Variant.VT_DISPATCH),
         DockDockPosition(30069, Variant.VT_INT),
         ExpandCollapseExpandCollapseState(30070, Variant.VT_INT),
         MultipleViewCurrentView(30071, Variant.VT_DISPATCH),
         MultipleViewSupportedViews(30072, Variant.VT_ARRAY),
         WindowCanMaximize(30073, Variant.VT_BOOL),
         WindowCanMinimize(30074, Variant.VT_BOOL),
         WindowWindowVisualState(30075, Variant.VT_INT),
         WindowWindowInteractionState(30076, Variant.VT_INT),
         WindowIsModal(30077, Variant.VT_BOOL),
         WindowIsTopmost(30078, Variant.VT_BOOL),
         SelectionItemIsSelected(30079, Variant.VT_BOOL),
         SelectionItemSelectionContainer(30080, Variant.VT_DISPATCH),
         TableRowHeaders(30081, Variant.VT_ARRAY),
         TableColumnHeaders(30082, Variant.VT_ARRAY),
         TableRowOrColumnMajor(30083, Variant.VT_INT),
         TableItemRowHeaderItems(30084, Variant.VT_ARRAY),
         TableItemColumnHeaderItems(30085, Variant.VT_ARRAY),
         ToggleToggleState(30086, Variant.VT_INT),
         TransformCanMove(30087, Variant.VT_BOOL),
         TransformCanResize(30088, Variant.VT_BOOL),
         TransformCanRotate(30089, Variant.VT_BOOL),
         IsLegacyIAccessiblePatternAvailable(30090, Variant.VT_BOOL),
         LegacyIAccessibleChildId(30091, Variant.VT_INT),
         LegacyIAccessibleName(30092, Variant.VT_LPWSTR),
         LegacyIAccessibleValue(30093, Variant.VT_LPWSTR),
         LegacyIAccessibleDescription(30094, Variant.VT_LPWSTR),
         LegacyIAccessibleRole(30095, Variant.VT_LPWSTR),
         LegacyIAccessibleState(30096, Variant.VT_LPWSTR),
         LegacyIAccessibleHelp(30097, Variant.VT_LPWSTR),
         LegacyIAccessibleKeyboardShortcut(30098, Variant.VT_LPWSTR),
         LegacyIAccessibleSelection(30099, Variant.VT_LPWSTR),
         LegacyIAccessibleDefaultAction(30100, Variant.VT_LPWSTR),
         AriaRole(30101, Variant.VT_LPWSTR),
         AriaProperties(30102, Variant.VT_ARRAY),
         IsDataValidForForm(30103, Variant.VT_BOOL),
         ControllerFor(30104, Variant.VT_DISPATCH),
         DescribedBy(30105, Variant.VT_DISPATCH),
         FlowsTo(30106, Variant.VT_DISPATCH),
         ProviderDescription(30107, Variant.VT_LPWSTR),
         IsItemContainerPatternAvailable(30108, Variant.VT_BOOL),
         IsVirtualizedItemPatternAvailable(30109, Variant.VT_BOOL),
         IsSynchronizedInputPatternAvailable(30110, Variant.VT_BOOL);
         
         private int value;
         private int variantType;

        private AutomationProperty(int value, int variantType) {
            this.value = value;
            this.variantType = variantType;
        }
    
        public int getValue() {
            return value;
        }
        
        public int getVariantType() {
            return variantType;
        }
}
