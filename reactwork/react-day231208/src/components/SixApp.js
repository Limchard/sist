import React from 'react';
import Alert from "@mui/material/Alert";
import MoodIcon from '@mui/icons-material/Mood';

function SixApp(props) {
    return (
        <div>
            <h3 className='alert alert-dark'>SixApp입니다.</h3>
            <Alert severity="success"><MoodIcon/></Alert>
        </div>
    );
}

export default SixApp;