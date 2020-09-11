package hustle.sims.inc.gadsleadership;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter {
    int tabCount;
    public TabPagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.tabCount = numberOfTabs;
    } @
            Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:LeadersHoursFragment leadersHoursFragment = new LeadersHoursFragment();
                return leadersHoursFragment;
            case 1:
                LeadersSkillIQFragment leadersSkillIQFragment = new LeadersSkillIQFragment();
                return leadersSkillIQFragment;
            default:
                return null;
        }
    } @
            Override
    public int getCount() {
        return tabCount;
    }
}
