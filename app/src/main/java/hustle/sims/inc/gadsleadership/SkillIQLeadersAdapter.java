package hustle.sims.inc.gadsleadership;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SkillIQLeadersAdapter extends RecyclerView.Adapter<SkillIQLeadersAdapter.SkillIQLeadersViewHolder> {
    Context context;
    List<LeadersSkillIQ> mLeadersSkillIQS;

    public SkillIQLeadersAdapter(Context context, List<LeadersSkillIQ> leadersSkillIQS) {
        this.context = context;
        mLeadersSkillIQS = leadersSkillIQS;
    }

    @Override
    public SkillIQLeadersViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.learning_leaders_adapter, null);
        SkillIQLeadersViewHolder learningLeadersViewHolder = new SkillIQLeadersViewHolder(view);
        return learningLeadersViewHolder;
    }

    @Override
    public void onBindViewHolder(SkillIQLeadersViewHolder holder, final int position){
        //set data
        holder.learner_name.setText(mLeadersSkillIQS.get(position).getName());
        holder.learner_skill_iq.setText(mLeadersSkillIQS.get(position).getScore() + " skill IQ, " + mLeadersSkillIQS.get(position).getCountry());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with user name
                Toast.makeText(context, mLeadersSkillIQS.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount(){
        return mLeadersSkillIQS.size();
    }


    class SkillIQLeadersViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView learner_name, learner_skill_iq;

        public SkillIQLeadersViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            learner_name = (TextView) itemView.findViewById(R.id.learner_name);
            learner_skill_iq = (TextView) itemView.findViewById(R.id.learner_skill_iq);
        }
    }
}
