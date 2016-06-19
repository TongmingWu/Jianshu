package com.tongming.jianshu.provider;

import android.content.SearchRecentSuggestionsProvider;

/**
 * Created by Tongming on 2016/6/19.
 */
public class SearchSuggestionProvider extends SearchRecentSuggestionsProvider {
    public final static String AUTHORITY = "com.tongming.jianshu.provider.SearchSuggestionProvider";

    public final static int MODE = DATABASE_MODE_QUERIES;

    public SearchSuggestionProvider() {
        super();
        setupSuggestions(AUTHORITY, MODE);
    }
}
