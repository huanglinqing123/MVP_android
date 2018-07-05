package mvp.com.utils;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 *
 */
public class DialogUtils {

    public static ProgressDialog pd;

    public static void createListDialog(Context context, String[] arrays,DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setItems(arrays, listener);
        AlertDialog simplelistdialog=builder.create();
        simplelistdialog.show();

    }

    public static void createMessageDialog(Context context, String title, String message,
        String positive, Dialog.OnClickListener listener1, String nagetive,
        Dialog.OnClickListener listener2) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setPositiveButton(positive, listener1);
        builder.setNegativeButton(nagetive, listener2);
        builder.create().show();
    }
    public static void createMessageDialog(Context context, String title, String message,
                                           String positive, Dialog.OnClickListener listener1) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setPositiveButton(positive, listener1);
        builder.create().show();
    }

    public static void createMessageDialog(Context context, String title, String message,
        String positive, Dialog.OnClickListener listener1, String nagetive, boolean isoutSide,
        DialogInterface.OnDismissListener listener2) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setPositiveButton(positive, listener1);
        builder.setNegativeButton(nagetive, null);
        builder.setCancelable(isoutSide);
        builder.setOnDismissListener(listener2);
        builder.create().show();
    }

    public static void showProgressDialog(Context context, String mess) {
        pd = new ProgressDialog(context);
        //设置进度条样式
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setIndeterminate(false);
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);
        pd.setMessage(mess);
        pd.show();
    }

    public static void dismissProgressDialog() {
        if (pd == null) {
            return;
        } else {
            if (pd.isShowing()) {
                pd.dismiss();
            }
        }
    }
}
