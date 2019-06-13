package com.zoom.kiki.outofline;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceAlbums;
    private List<Album> albums = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Album> albums, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataDeleted();
    }

    public DatabaseHelper() {

        mDatabase = FirebaseDatabase.getInstance();
        mReferenceAlbums = mDatabase.getReference("Albums");
    }

    public void readAlbums(final DataStatus dataStatus){
        mReferenceAlbums.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                albums.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Album album = keyNode.getValue(Album.class);
                    albums.add(album);
                }

                dataStatus.DataIsLoaded(albums, keys);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
