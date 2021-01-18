package sergeevvs.fc_mvp.interfaces

import sergeevvs.fc_mvp.data.Team

interface ICardModel {
    fun getTeam(id: Int): Team
}