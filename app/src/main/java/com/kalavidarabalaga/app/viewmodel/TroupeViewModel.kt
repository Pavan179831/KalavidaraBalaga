package com.kalavidarabalaga.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kalavidarabalaga.app.model.Troupe
import com.kalavidarabalaga.app.repository.TroupeRepository
import kotlinx.coroutines.launch

/**
 * ViewModel shared between HomeFragment and SearchFragment.
 * Exposes LiveData for UI state.
 */
class TroupeViewModel : ViewModel() {

    private val repository = TroupeRepository()

    // --- Home State ---
    private val _featuredTroupes = MutableLiveData<List<Troupe>>()
    val featuredTroupes: LiveData<List<Troupe>> = _featuredTroupes

    // --- Search State ---
    private val _searchResults = MutableLiveData<List<Troupe>>()
    val searchResults: LiveData<List<Troupe>> = _searchResults

    // --- Loading State ---
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    // --- Error State ---
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    // --- Single Troupe (for profile screen) ---
    private val _selectedTroupe = MutableLiveData<Troupe?>()
    val selectedTroupe: LiveData<Troupe?> = _selectedTroupe

    init {
        loadFeaturedTroupes()
    }

    /** Load featured troupes for the Home screen */
    fun loadFeaturedTroupes() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val list = repository.getFeaturedTroupes()
                _featuredTroupes.value = list
                _error.value = null
            } catch (e: Exception) {
                _error.value = "Failed to load troupes: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    /** Search troupes with optional filters */
    fun searchTroupes(
        query: String? = null,
        district: String? = null,
        artType: String? = null
    ) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val list = repository.searchTroupes(district, artType, query)
                _searchResults.value = list
                _error.value = null
            } catch (e: Exception) {
                _error.value = "Search failed: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    /** Load all troupes (initial search screen load) */
    fun loadAllTroupes() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val list = repository.getAllTroupes()
                _searchResults.value = list
                _error.value = null
            } catch (e: Exception) {
                _error.value = "Failed to load troupes: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    /** Set the troupe selected for profile view */
    fun selectTroupe(troupe: Troupe) {
        _selectedTroupe.value = troupe
    }

    /** Seed sample data (call once for demo) */
    fun seedData() {
        viewModelScope.launch {
            try {
                repository.seedSampleData()
                loadFeaturedTroupes()
            } catch (e: Exception) {
                _error.value = "Seed failed: ${e.message}"
            }
        }
    }
}
