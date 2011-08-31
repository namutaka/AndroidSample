# -*- coding: utf-8 -*-

# monkeyrunnerモジュールのインポート
from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

# デバイスに接続し、MonkeyDeviceオブジェクトを返します。
device = MonkeyRunner.waitForConnection()

# パッケージのインストール
# このメソッドがtrueを返したなら、インストールは成功です。
device.installPackage('bin/HelloWorld.apk')

# sets a variable with the package's internal name
package = 'namu.taka'

# sets a variable with the name of an Activity in the package
activity = 'namu.taka.HelloWorld'

# sets the name of the component to start
runComponent = package + '/' + activity

# Runs the component
device.startActivity(component=runComponent)

# メニューキーの押下
device.press('KEYCODE_MENU','DOWN_AND_UP')

# スクリーンショットの取得
result = device.takeSnapshot()

# スクリーンショットの書き出し
result.writeToFile('temp/shot1.png','png')

