package in.msme.cic;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled") public class Webview extends Fragment {

	WebView web;
    //ArrayList<String> url = new ArrayList<String>();
	private static final String ARG_SECTION_NUMBER = "section_number";
	SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
	
	public static Webview newInstance(int sectionNumber) {
		Webview fragment = new Webview();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;									
		
	}

	public Webview() {
		
		 
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View V = inflater.inflate(R.layout.webview, container, false);
		String url = sharedPref.getString("url_link", "link in webview");
		web = (WebView) V.findViewById(R.id.website);
        web.getSettings().setJavaScriptEnabled(true);		
		web.loadUrl(url);

		return V;
	}
}