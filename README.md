# Header
- Matthew Shiroma
- ID: 1902187
- shiro105@mail.chapman.edu
- CPSC 356 - 01
# Assignment 0: Create a Service Tip Calculator

## Specifications
```
You are to create a tip calculator app that calculates and displays an appropriate tip based on a
total price and service score on a scale of 1-10. The scoring system is as follows:
1<=score<=3 yields a 10% tip
4<=score<=5 yields a 13% tip
6<=score<=7 yields a 15% tip
8<=score<=9 yields a 20% tip
score==10 yields a 25% tip
Other than the specifics above, the implementation is completely up to you. 
Be sure to have proper error checking in place. Deductions will be made if I can crash your app.
```

### Design Choices
- I approached this by using all of the tools that I was first introduced to. 
EditText and ViewText were the two Widgets that I was first exposed to in this class, 
so I took advantage of those resources. I also used a SeekBar in order to implement the Tip Scale. I use

### Source Files
- Other than the pre generated files Android Studio makes, I made the TipScreen.java, thumb_image.xml, activity_screen_tip.xml and strings.xml.

### Refrences
- Kevin Lin for the initial suggestion of a SeekBar.
- https://stackoverflow.com/questions/41693154/custom-seekbar-thumb-size-color-and-background/42160162
- https://github.com/ChapmanCPSC356Fall2017/HelloName/blob/master/HelloWorld/app/src/main/java/edu/chapman/cpsc356/helloworld/MainActivity.java
- https://github.com/ChapmanCPSC356Fall2017/HelloName/blob/master/HelloWorld/app/src/main/res/layout/activity_main.xml
- https://stackoverflow.com/questions/10978038/restrict-edittext-to-single-line
- https://stackoverflow.com/questions/3285412/limit-text-length-of-edittext-in-android
- https://developer.android.com/reference/android/text/InputType.html#TYPE_CLASS_NUMBER
- https://stackoverflow.com/questions/3490951/how-to-limit-seekbar
- https://stackoverflow.com/questions/4885254/string-format-to-format-double-in-java
- https://stackoverflow.com/questions/6034523/format-an-integer-using-java-string-format
- https://stackoverflow.com/questions/6034523/format-an-integer-using-java-string-format
- https://stackoverflow.com/questions/8560248/string-formatting-with-variable-number-of-arguments-in-java?lq=1
- https://stackoverflow.com/questions/1915074/understanding-the-in-javas-format-strings
- https://stackoverflow.com/questions/22945495/reset-seekbar-to-beginning-on-back-activity
- https://stackoverflow.com/questions/3033135/android-seekbar-minimum-value
