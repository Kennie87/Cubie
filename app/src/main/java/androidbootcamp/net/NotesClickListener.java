package androidbootcamp.net;

import androidx.cardview.widget.CardView;

import androidbootcamp.net.Models.Notes;

public interface NotesClickListener {
    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);
}
