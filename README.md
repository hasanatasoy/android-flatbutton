# FLAT BUTTON IN ANDROID
### Examples

![](https://github.com/hasanatasoy/android-flatbutton/blob/master/example.png)

### Usages

**Copy Button.kt and paste your package, copy xml files and paste your xml files inside and use this attributes in your layout xml file:**
```
-Add this line in your base layout as a attribute xmlns:appAttr="http://schemas.android.com/apk/res-auto"
-Defining button <yourpackagename.Button.../>
```
**Attributes**
```
ButtonType = appAttr:buttonType = "Muittin" ( you must use button type for now. use Muittin )
Shape = appAttr:shape = "Rectangle" or "Oval" or "Ring" ( Default rectangle )
Background color = appAttr:backgroundColor = "#FFFFFF"
Corner radius = appAttr:cornerRadius = "SomeIntegerValue"
Stroke color = appAttr:strokeColor = "#FFFFFF"
Stroke width = appAttr:strokeWidth = "SomeIntegerValue"
Also you can use default button attributes
```
**Let's make an example together**
```
    <yourpackagename.Button
            android:layout_width="150dp"
            android:layout_height="43dp"
            appAttr:buttonType="Muittin"
            appAttr:shape = "Rectangle"
            appAttr:backgroundColor="#FFFFFF"
            appAttr:strokeWidth = "4"
            appAttr:strokeColor = "#22FF22"
            appAttr:cornerRadius = "25"
            android:text="Hello World!"
            android:textColor = "#22FF22" />
```
