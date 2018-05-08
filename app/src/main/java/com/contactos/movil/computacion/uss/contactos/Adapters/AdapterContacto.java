package com.contactos.movil.computacion.uss.contactos.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.contactos.movil.computacion.uss.contactos.Modelo.Contacto;
import com.contactos.movil.computacion.uss.contactos.R;

import java.util.List;


public class AdapterContacto extends BaseAdapter {

    private List<Contacto> list;
    private Activity activity;


    public AdapterContacto(Activity activity, List<Contacto> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View v = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.detalle_contacto, null);

        }
        Contacto movimiento = list.get(position);
        TextView tvNombreV = (TextView) v.findViewById(R.id.tvNombreV);
        tvNombreV.setText(movimiento.getNombre());
        final TextView tvNumeroV = (TextView) v.findViewById(R.id.tvNumeroV);
        tvNumeroV.setText(movimiento.getTelefono());
        TextView tvEmailV = (TextView) v.findViewById(R.id.tvEmailV);
        tvEmailV.setText(movimiento.getEmail());


        ImageButton BotonLlamar= (ImageButton) v.findViewById(R.id.botom_llamar);
        BotonLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent llamar = new Intent(Intent.ACTION_CALL);
                llamar.setData(Uri.parse("tel:"+tvNumeroV.getText().toString()));
                view.getContext().startActivity(llamar);
            }
        });
        return v;
    }
}