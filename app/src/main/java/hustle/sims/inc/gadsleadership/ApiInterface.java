package hustle.sims.inc.gadsleadership;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/api/hours")
    public Call<List<LeadersHours>> getLeadersHours();

    @GET("/api/skilliq")
    public Call<List<LeadersSkillIQ>> getLeadersSkillIQ();
}
