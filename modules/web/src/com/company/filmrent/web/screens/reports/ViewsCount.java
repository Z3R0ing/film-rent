package com.company.filmrent.web.screens.reports;

import com.company.filmrent.entity.movie.Movie;
import com.company.filmrent.service.MoviesService;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.actions.list.ExcelAction;
import com.haulmont.cuba.gui.components.DataGrid;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import javax.inject.Named;

@UiController("filmrent_ViewsCount")
@UiDescriptor("views-count.xml")
@LoadDataBeforeShow
public class ViewsCount extends Screen {

    @Inject
    private Messages messages;
    @Inject
    private MoviesService moviesService;
    @Inject
    private DataGrid<Movie> forExport;
    @Named("forExport.excel")
    private ExcelAction forExportExcel;

    @Subscribe
    protected void onInit(InitEvent event) {
        // set file name to export
        forExportExcel.setFileName(messages.getMessage(this.getClass(), "viewsCount.caption"));
        // add columnt to table
        DataGrid.Column column = forExport.addGeneratedColumn("viewCount", new DataGrid.ColumnGenerator<Movie, String>(){
            @Override
            public String getValue(DataGrid.ColumnGeneratorEvent<Movie> event){
                return String.valueOf(moviesService.getViews(event.getItem()));
            }

            @Override
            public Class<String> getType(){
                return String.class;
            }
        }, 1);
        column.setCaption(messages.getMessage(this.getClass(), "viewsCount.viewCount"));
    }

}