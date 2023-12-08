import React from 'react';
import Alert from "@mui/material/Alert";
import ThumbUpOffAltIcon from '@mui/icons-material/ThumbUpOffAlt';

function FiveApp(props) {
    return (
        <div>
            <h3 className='alert alert-danger'>FiveApp입니다.</h3>
            <Alert severity="warning"><ThumbUpOffAltIcon/></Alert>
        </div>
    );
}

export default FiveApp;