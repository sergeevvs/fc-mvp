package sergeevvs.fc_mvp.presenter

import sergeevvs.fc_mvp.interfaces.MvpContract

abstract class BasePresenter<V : MvpContract.IView> : MvpContract.IPresenter<V> {

    var view: V? = null

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

}