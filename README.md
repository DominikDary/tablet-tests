TABLET-TESTS
============

Project to play with the Opera Mobile Emulator to test a tablet web site with [Opera Driver](https://github.com/operasoftware/operadriver).

This is only tested on MAC.

Using Opera Mobile Emulator
---------------------------

To get started you must install first the Opera Mobile Emulator from the [App Store](https://itunes.apple.com/de/app/opera-mobile-emulator/id515290645?mt=12)


Using Android Driver (Selenium)
-------------------------------

For running the test you need to create an Android Emulator first and then download the [android-server-2.21.0.apk](http://selenium.googlecode.com/files/android-server-2.21.0.apk). After doing this do:

* install the app on your emulator with: *adb install -r  android-server.apk*
* start the app: *adb shell am start -a android.intent.action.MAIN -n org.openqa.selenium.android.app/.MainActivity*
* activate the port forwarding: *adb forward tcp:8080 tcp:8080*
* now you are able to run the tests
