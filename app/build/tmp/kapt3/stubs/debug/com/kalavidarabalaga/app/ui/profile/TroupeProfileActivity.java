package com.kalavidarabalaga.app.ui.profile;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J&\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001a\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002J\b\u0010\u001c\u001a\u00020\nH\u0002J\b\u0010\u001d\u001a\u00020\nH\u0002J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/kalavidarabalaga/app/ui/profile/TroupeProfileActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "artForm", "Lcom/kalavidarabalaga/app/data/ArtFormData$ArtForm;", "binding", "Lcom/kalavidarabalaga/app/databinding/ActivityTroupeProfileBinding;", "prefs", "Lcom/kalavidarabalaga/app/data/UserPreferences;", "dialPhone", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "populateList", "container", "Landroid/widget/LinearLayout;", "items", "", "", "icon", "populateProfile", "setupButtons", "setupGallery", "setupToolbar", "showBookingDialog", "showDatePicker", "target", "Landroid/widget/EditText;", "Companion", "app_debug"})
public final class TroupeProfileActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_ART_FORM = "extra_art_form";
    private com.kalavidarabalaga.app.databinding.ActivityTroupeProfileBinding binding;
    private com.kalavidarabalaga.app.data.UserPreferences prefs;
    private com.kalavidarabalaga.app.data.ArtFormData.ArtForm artForm;
    @org.jetbrains.annotations.NotNull()
    public static final com.kalavidarabalaga.app.ui.profile.TroupeProfileActivity.Companion Companion = null;
    
    public TroupeProfileActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupToolbar() {
    }
    
    private final void populateProfile() {
    }
    
    /**
     * Adds a styled row for each item in the list
     */
    private final void populateList(android.widget.LinearLayout container, java.util.List<java.lang.String> items, java.lang.String icon) {
    }
    
    private final void setupButtons() {
    }
    
    private final void dialPhone() {
    }
    
    private final void showBookingDialog() {
    }
    
    private final void showDatePicker(android.widget.EditText target) {
    }
    
    private final void setupGallery() {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/kalavidarabalaga/app/ui/profile/TroupeProfileActivity$Companion;", "", "()V", "EXTRA_ART_FORM", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}