package com.example.eventapp;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class EventAdapter extends ArrayAdapter<Acara> {
	private Context context;
	private Acara acara;
	private int resourceLayout;

	public EventAdapter(Context context, int resource, List<Acara> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.resourceLayout = resource;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		acara = getItem(position);
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = inflater.inflate(resourceLayout, parent, false);
				
				TextView textAcara = (TextView) convertView.findViewById(R.id.acara);
				TextView textTanggal = (TextView) convertView.findViewById(R.id.tanggal);
				TextView textJam = (TextView) convertView.findViewById(R.id.jam);
				
				textAcara.setText(acara.getNamaAcara());
				textTanggal.setText(acara.getTanggal());
				textJam.setText(acara.getJam());
				
		return convertView;
	}
}
