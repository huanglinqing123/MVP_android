package mvp.com.utils;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.blankj.utilcode.utils.StringUtils;
import org.apache.http.conn.util.InetAddressUtils;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
/**
 *  Created by haozhangfu on 2016.4.24.
 */
public class DeviceUtils {
    /**
     * ip地址
     */
    public static String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()&& InetAddressUtils.isIPv4Address(inetAddress
                        .getHostAddress())) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException ex) {
            ToastUtil.show(ex.getMessage());
        }
        return "";
    }

    /**
     * 品牌
     */
    public static String getDeviceBrand() {
        return android.os.Build.BRAND;
    }
    /**
     * 获取设备类型
     */
    public static String getDeviceModel() {
        if (StringUtils.isEmpty(android.os.Build.MODEL))
            return "Android_Device";
        else
            return android.os.Build.MODEL;
    }


    /**
     * 获取操作系统版本号(如：2.3.3)
     * */
    public static String getDeviceVersionName() {
        return android.os.Build.VERSION.RELEASE;
    }


    /*
     * 获取应用名
     */
    public static String getVersionName(Context context){
        String versionName = null;
        try {
            //获取包管理者
            PackageManager pm = context.getPackageManager();
            //获取packageInfo
            PackageInfo info = pm.getPackageInfo(context.getPackageName(), 0);
            //获取versionName
            versionName = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return versionName;
    }
    /*
     * 获取应用版本
     */
    public static int getVersionCode(Context context){

        int versionCode = 0;
        try {
            //获取包管理者
            PackageManager pm = context.getPackageManager();
            //获取packageInfo
            PackageInfo info = pm.getPackageInfo(context.getPackageName(), 0);
            //获取versionCode
            versionCode = info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return versionCode;
    }
}
