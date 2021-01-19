package sergeevvs.fc_mvp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import sergeevvs.fc_mvp.R
import sergeevvs.fc_mvp.data.Player
import sergeevvs.fc_mvp.databinding.PlayerCardBinding
import sergeevvs.fc_mvp.presenter.SquadListPresenter

class SquadAdapter(private val presenter: SquadListPresenter) :
    RecyclerView.Adapter<SquadAdapter.PlayerCardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerCardHolder {
        return PlayerCardHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.player_card,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlayerCardHolder, position: Int) {
        presenter.onBindPlayerAtPosition(holder, position)
    }

    override fun getItemCount() = presenter.getPlayerCount()

    class PlayerCardHolder(private val binding: PlayerCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindTeam(player: Player) {
            binding.player = player
            binding.executePendingBindings()

            /*Glide.with(binding.root)
                    .load(team.crestUrl)
                    .into(binding.cardImage)*/
        }
    }
}