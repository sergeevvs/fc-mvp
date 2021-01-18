package sergeevvs.fc_mvp.presenter

import sergeevvs.fc_mvp.interfaces.ICardModel
import sergeevvs.fc_mvp.interfaces.ICardPresenter
import sergeevvs.fc_mvp.interfaces.ICardView

class CardPresenter(private val model: ICardModel): BasePresenter<ICardView>(), ICardPresenter {
    override fun viewIsReady() {
        TODO("Not yet implemented")
    }
}