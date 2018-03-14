package me.angeloid.gotravel.base;

import com.angeloid.mvplibrary.BasePresenter;
import com.angeloid.mvplibrary.MvpFragment;
import com.orhanobut.logger.Logger;
import com.xiasuhuei321.loadingdialog.view.LoadingDialog;


/**
 * @author yunjw
 *         Created at 2018/1/26.
 *         Time is 19:36 now.
 *         (#^.^#)
 */

public abstract class BaseFragment<P extends BasePresenter> extends MvpFragment<P> {
    private LoadingDialog loadingDialog;
    @Override
    protected abstract P initPresenter();

    @Override
    public void showLoading(String str) {
        if(loadingDialog == null){
            loadingDialog = new LoadingDialog(getContext());
        }
        loadingDialog
                .setLoadingText(str)
                .show();
    }

    @Override
    public void hideLoading() {
        if(loadingDialog != null){
            loadingDialog.close();
            loadingDialog = null;
        }
    }


}
