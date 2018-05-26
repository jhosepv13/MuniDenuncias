package moviles.proyectos.munidenuncias.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import moviles.proyectos.munidenuncias.Models.Denuncia;
import moviles.proyectos.munidenuncias.R;
import moviles.proyectos.munidenuncias.Services.ApiService;

/**
 * Created by Alumno on 11/05/2018.
 */

public class DenunciasAdapter extends RecyclerView.Adapter<DenunciasAdapter.ViewHolder> {

    private List<Denuncia> denuncias;

    public DenunciasAdapter() {
        this.denuncias = new ArrayList<>();
    }

    public void setDenuncias(List<Denuncia> denuncias) {
        this.denuncias = denuncias;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView fotoImage;
        public TextView tituloText;
        public TextView usuarios_idText;
        public TextView contenidoText;

        public ViewHolder(View itemView) {
            super(itemView);
            fotoImage = (ImageView) itemView.findViewById(R.id.foto_image);
            tituloText = (TextView) itemView.findViewById(R.id.titulo_text);
            usuarios_idText = (TextView) itemView.findViewById(R.id.nombre_text);
            contenidoText = (TextView) itemView.findViewById(R.id.contenido_text);
        }
    }

    @Override
    public DenunciasAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_denuncia, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DenunciasAdapter.ViewHolder viewHolder, int position) {

        Denuncia denuncia = this.denuncias.get(position);

        viewHolder.tituloText.setText(denuncia.getTitulo());
        if("1" == denuncia.getUsuarios_id()){
            viewHolder.usuarios_idText.setText("Denuncia hecha por un ciudadano");
        }else{
            viewHolder.usuarios_idText.setText("Denuncia hecha por un sereno");
        }

        viewHolder.contenidoText.setText(denuncia.getContenido());


        String url = ApiService.API_BASE_URL + "/images/" + denuncia.getImage();
        Picasso.with(viewHolder.itemView.getContext()).load(url).into(viewHolder.fotoImage);

    }

    @Override
    public int getItemCount() {
        return this.denuncias.size();
    }
}
