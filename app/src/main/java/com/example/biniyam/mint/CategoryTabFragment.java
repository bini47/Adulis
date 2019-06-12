package com.example.biniyam.mint;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class CategoryTabFragment extends Fragment{
    private int tabNumber;
    // AboutTabFragment.createTab stores the tab number in the bundle arguments so it can be referenced from onCreate().
    public static CategoryTabFragment createTab(int tab) {
        Bundle thisTabArguments = new Bundle();
        thisTabArguments.putInt("Tab", tab);
        CategoryTabFragment thisTab = new CategoryTabFragment();
        thisTab.setArguments(thisTabArguments);
        return thisTab;
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Store the tab number in tabNumber.
        tabNumber = getArguments().getInt("Tab");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View tabLayout;
        Toast.makeText(getContext(), String.valueOf(tabNumber), Toast.LENGTH_SHORT).show();
        // Load the about tab layout.  Tab numbers start at 0.
        if (tabNumber == 0) {
            // Setting false at the end of inflater.inflate does not attach the inflated layout as a child of container.
            // The fragment will take care of attaching the root automatically.
            tabLayout = inflater.inflate(R.layout.activity_shop, container, false);
        } else { // load a WebView for all the other tabs.  Tab numbers start at 0.
            // Setting false at the end of inflater.inflate does not attach the inflated layout as a child of container.
            // The fragment will take care of attaching the root automatically.
            tabLayout = inflater.inflate(R.layout.activity_shop, container, false);


            switch (tabNumber) {
                case 1:
                    Bundle category = new Bundle();
                    category.putString("cata", "clothing");

                    new AllProducts().setArguments(category);
                    break;

                case 2:
                    Bundle category2 = new Bundle();
                    category2.putString("cata", "shoes");
                    new AllProducts().setArguments(category2);
                    break;

                case 3:
                    new AllProducts();
                    break;

                case 4:
                    new AllProducts();
                    break;

                case 5:
                    new AllProducts();
                    break;

                case 6:
                    Bundle category3 = new Bundle();
                    category3.putString("cata", "some thing");
                    new AllProducts().setArguments(category3);
                    break;


                    case 7:
                        new AllProducts();
                    break;


                default:
                    break;
            }
        }

        return tabLayout;
    }
}