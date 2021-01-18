package sergeevvs.fc_mvp.interfaces

import androidx.navigation.NavController

interface MvpContract {

    interface IView {
        fun getNavController(): NavController
    }

    interface IPresenter<V : IView> {
        fun attachView(view: V)
        fun detachView()
        fun viewIsReady()
    }

    interface IModel

}