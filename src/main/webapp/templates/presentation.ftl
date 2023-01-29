<h6>Choose a presentation</h6>
<#list presentations as presentation>
    <div>
        <p>ID: ${presentation.id}</p>
        <p>Title: ${presentation.title}</p>
        <p>Duration: ${presentation.dauer}</p>
        <p>Hall: ${presentation.hall}</p>
        <p>Start Time: ${presentation.startTime}</p>
        <p>End Time: ${presentation.endTime}</p>
        <p>Archived: ${presentation.isArchived}</p>
    </div>
</#list>