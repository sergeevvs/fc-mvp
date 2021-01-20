package sergeevvs.fc_mvp.main

import android.os.Bundle

abstract class BasePresenter<V : MvpView> : MvpPresenter<V> {

    var view: V? = null

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

}