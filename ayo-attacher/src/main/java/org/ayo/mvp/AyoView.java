package org.ayo.mvp;

/**
 * Created by Administrator on 2016/8/30.
 */
public interface AyoView<T extends AyoPresenter> {

    void attachPresenter(T presenter);
    void detachPresenter();

}
