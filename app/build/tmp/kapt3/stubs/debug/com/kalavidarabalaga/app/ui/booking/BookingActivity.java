package com.kalavidarabalaga.app.ui.booking;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/kalavidarabalaga/app/ui/booking/BookingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/kalavidarabalaga/app/databinding/ActivityBookingBinding;", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "troupeId", "", "troupeName", "troupePhone", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "showDatePicker", "submitInquiry", "Companion", "app_debug"})
public final class BookingActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_TROUPE_NAME = "extra_troupe_name";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_TROUPE_PHONE = "extra_troupe_phone";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_TROUPE_ID = "extra_troupe_id";
    private com.kalavidarabalaga.app.databinding.ActivityBookingBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore db = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String troupeName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String troupePhone = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String troupeId = "";
    @org.jetbrains.annotations.NotNull()
    public static final com.kalavidarabalaga.app.ui.booking.BookingActivity.Companion Companion = null;
    
    public BookingActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showDatePicker() {
    }
    
    private final void submitInquiry() {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/kalavidarabalaga/app/ui/booking/BookingActivity$Companion;", "", "()V", "EXTRA_TROUPE_ID", "", "EXTRA_TROUPE_NAME", "EXTRA_TROUPE_PHONE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}