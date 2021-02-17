package com.aem.testreact.core.models;

import javax.annotation.PostConstruct;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import com.adobe.cq.export.json.ComponentExporter;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Exporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Model(adaptables = SlingHttpServletRequest.class,
        adapters = {ComponentExporter.class},
        resourceType = LinkContentModel.RESOURCE_TYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class LinkContentModel implements ComponentExporter {
    protected static final String RESOURCE_TYPE = "spa-react-aem/components/link-content";

    @ValueMapValue(injectionStrategy=InjectionStrategy.OPTIONAL)
    protected String url;

    @SlingObject
    private ResourceResolver resourceResolver;

    private List<Page> linkPages;

    @PostConstruct
    protected void init(){
        if (url != null){
            PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
            Page parentPage = pageManager.getPage(url);

            if(parentPage != null){
                Iterator<Page> iterator = parentPage.listChildren();

                linkPages = StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false)
                        .collect(Collectors.toList());

            }
        }
    }

    public List<Page> getLinkPages() {
        return linkPages;
    }

    public String getUrl() {
        return url;
    }

    public String getExportedType() {
        return RESOURCE_TYPE;
    }
}
