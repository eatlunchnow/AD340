package com.zoom.kiki.outofline;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewConfig {

   /* private Context mContext;

    class AlbumItemView extends RecyclerView.ViewHolder {

        private TextView mAlbumArtist;
        private TextView mAlbumTitle;
        private TextView mAlbumReleaseYear;

        private String key;

        public AlbumItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext),
            inflate(R.layout.album_list_item, parent, false));



            mAlbumArtist = (TextView) itemView.findViewById(R.id.artist_name);
            mAlbumTitle = (TextView) itemView.findViewById(R.id.album_title);
            mAlbumReleaseYear = (TextView) itemView.findViewById(R.id.album_year);

        }

        public void bind(Album album, String key){
            mAlbumArtist.setText(album.getAlbumArtist());
            mAlbumTitle.setText(album.getAlbumTitle());
            mAlbumReleaseYear.setText(album.getAlbumReleaseYear());
            this.key = key;
        }
    }

    class AlbumAdapter extends RecyclerView.Adapter<AlbumItemView>{
        private List<Album> mAlbumList;
        private List<String> mKeys;

        public AlbumAdapter(List<Album> mAlbumList, List<String> mKeys){
            this.mAlbumList = mAlbumList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public AlbumItemView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull AlbumItemView albumItemView, int i) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }*/
}
