/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.architecture.blueprints.todoapp

import android.databinding.BindingAdapter
import android.support.v4.widget.SwipeRefreshLayout
import android.widget.ListView
import com.example.android.architecture.blueprints.todoapp.data.Task
import com.example.android.architecture.blueprints.todoapp.tasks.TasksFragment

import com.example.android.architecture.blueprints.todoapp.tasks.TasksViewModel


/**
 * Reloads the data when the pull-to-refresh is triggered.
 *
 *
 * Creates the `android:onRefresh` for a [SwipeRefreshLayout].
 */
@BindingAdapter("android:onRefresh")
fun setSwipeRefreshLayoutOnRefreshListener(view: ScrollChildSwipeRefreshLayout,
                                           viewModel: TasksViewModel) {
    view.setOnRefreshListener { viewModel.loadTasks(true) }
}

@BindingAdapter("app:items")
fun setItems(listView: ListView, items: List<Task>) {
    val adapter = listView.adapter as TasksFragment.TasksAdapter
    adapter.replaceData(items)
}
