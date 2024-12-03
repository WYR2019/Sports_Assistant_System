要引入的包
1、retrofit:implementation("com.squareup.retrofit2:retrofit:2.1.0")
            implementation("com.squareup.retrofit2:converter-gson:2.1.0")
            implementation("com.squareup.retrofit2:converter-scalars:2.1.0")
            implementation("com.squareup.picasso:picasso:2.5.2")
2、easypermissions:implementation("pub.devrel:easypermissions:3.0.0")
3、引入高德地图api地址：implementation(files("libs\\AMap2DMap_6.0.0_AMapSearch_9.7.2_AMapLocation_6.4.5_20240508.jar"))
4、Bmob后端云：
   implementation ("io.github.bmob:android-sdk:4.0.4")
   implementation ("io.reactivex.rxjava3:rxjava:3.1.9")
   implementation ("io.reactivex.rxjava3:rxandroid:3.0.2")
   implementation ("com.squareup.okhttp3:okhttp:4.8.1")
   implementation ("com.squareup.okio:okio:2.2.2")
   implementation ("com.google.code.gson:gson:2.8.5")
5、ViewPager2：
    implementation ("androidx.viewpager2:viewpager2:1.0.0-alpha02")
Android Manifest需要配置的内容：
1、声明高德地图服务
    <service android:name="com.amap.api.location.APSService"></service>
2、配置key
    <meta-data android:name="com.amap.api.v2.apikey" android:value="66df9925b8be9cafa2e76c7414eae243">//开发者申请的key

    </meta-data>
3、声明调取权限
<!-- 用于进行网络定位 -->
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" /> <!-- 用于访问GPS定位 -->
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" /> <!-- 用于获取运营商信息，用于支持提供运营商信息相关的接口 -->
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" /> <!-- 用于访问wifi网络信息，wifi信息会用于进行网络定位 -->
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" /> <!-- 用于获取wifi的获取权限，wifi信息会用来进行网络定位 -->
    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" /> <!-- 用于访问网络，网络定位需要上网 -->
    <uses-permission android:name="android.permission.INTERNET" /> <!-- 用于写入缓存数据到扩展存储卡 -->
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" /> <!-- 用于申请调用A-GPS模块 -->
    <uses-permission android:name="android.permission.ACCESS_LOCATION_EXTRA_COMMANDS" /> <!-- 如果设置了target >= 28 如果需要启动后台定位则必须声明这个权限 -->
    <uses-permission android:name="android.permission.FOREGROUND_SERVICE" /> <!-- 如果您的应用需要后台定位权限，且有可能运行在Android Q设备上,并且设置了target>28，必须增加这个权限声明 -->
    <uses-permission android:name="android.permission.ACCESS_BACKGROUND_LOCATION" />
